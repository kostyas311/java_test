package ru.grandsmeta.document.impl.xml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import ru.grandsmeta.document.Document;
import ru.grandsmeta.document.Item;


public abstract class XmlItem implements Item, Cloneable, Iterable<Item>, Comparable<Item> {
	
	private String xmlTag;
	private Document document;
	private Item parent;
	private List<Item> subItems;
	private boolean enabled;
	private Map<String, String> attribs;
	
	
	public XmlItem(Document document){		
		this.subItems = new LinkedList<Item>();
		this.document = document;
		this.enabled = true;
		this.attribs = new HashMap<String, String>();
		Set<String> keys = getAttribs();
		if (keys != null)
			for (String key : keys)
				this.attribs.put(key, null);
	}
	
	public XmlItem(Document document, String xmlTag){
		this(document);
		this.xmlTag = xmlTag;
	}
		
	abstract protected Set<String> getAttribs();
	
	abstract protected boolean needToSave();
		
	protected void doWriteXML(Element node){
		doSaveAttribs(node);
		for (Item item : this.subItems){
			if (item.isEnabled() && ((XmlItem) item).needToSave()){
				Element child = (Element) node.getOwnerDocument().createElement(((XmlItem)item).getXMLTag());
				node.appendChild(child);
				((XmlItem) item).doWriteXML(child);
			}
		}
	}
		
	public String toString(){
		return this.xmlTag + " " + this.attribs.toString();
	}
	
	protected void doReadXML(Element node){
		this.xmlTag = node.getTagName();
		
		if (Node.TEXT_NODE == node.getNodeType())
			return;
	
		doLoadAttribs(node);
		
		NodeList nodes = node.getChildNodes();
		for (int i = 0; i < nodes.getLength(); i++){
			Node item = nodes.item(i);
			if (item.getNodeType() == Node.ELEMENT_NODE){			
				XmlItem newItem = newItem(((Element) item).getNodeName());
				if (newItem != null){
					add(newItem);
					newItem.doReadXML((Element) item);
				}
			}
		}
	}
		
	abstract protected XmlItem newItem(String xmlTag);
	
	protected void doLoadAttribs(Element node){
		if (this.attribs == null)
			return;
		
		for (String attrib : this.attribs.keySet())
			if (node.hasAttribute(attrib))
				this.attribs.put(attrib, node.getAttribute(attrib));
	}
	
	protected void doSaveAttribs(Element node){
		if (this.attribs == null)
			return;
		
		for (Entry<String, String> es: this.attribs.entrySet()){
			if (es.getValue() != null)
				node.setAttribute(es.getKey(), es.getValue());
		}
	}
	
	public String getAttrib(String attrib){
		if (attrib == null)
			return null;
		
		return this.attribs.get(attrib);		
	}
	
	public void setAttrib(String attrib, String value){
		this.attribs.put(attrib, value);
	}
	
	public void assign(Item item){
		if (!item.getClass().equals(this.getClass()))
			return;
		
		clear();
		
		for (Map.Entry<String, String> e: attribs.entrySet()){
			String value = item.getAttrib(e.getKey());
			setAttrib(e.getKey(), value);
		}
		
		for (int i = 0; i < item.count(); i++){
			Item assignedItem = ((XmlItem) item).newItem( ((XmlItem)item.getItem(i)).getXMLTag());
			assignedItem.assign(item.getItem(i));
			add(assignedItem);
		}
	}
	
	@Override
	public void add(Item item) {
		this.subItems.add(item);
		item.setParent(this);
	}

	@Override
	public void remove(Item item) {
		this.remove(item);
		item.setParent(null);
	}

	@Override
	public void clear() {
		this.subItems.clear();
	}

	@Override
	public int count() {		
		return this.subItems.size();
	}

	@Override
	public Item getItem(int index) {
		return this.subItems.get(index);
	}

	@Override
	public void setItem(int index, Item item) {
		this.subItems.set(index, item);
	}

	@Override
	public Item getParent() {
		return this.parent;
	}

	@Override
	public boolean isEnabled() {
		return this.enabled;
	}

	@Override
	public void setEnabled(boolean value) {
		this.enabled = value;
	}

	@Override
	public Document getDocument() {
		return document;
	}
	
	public String getXMLTag(){
		return xmlTag;
	}

	@Override
	public void add(int index, Item item) {
		this.subItems.add(index, item);
		item.setParent(this);		
	}

	@Override
	public void remove(int index) {
		Item item = this.subItems.remove(index);
		item.setParent(null);
	}

	@Override
	public void setParent(Item item) {
		this.parent = item;		
	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return this.subItems.iterator();
	}

	@Override
	public int compareTo(Item o) {
		return o.hashCode() - this.hashCode();
	}

	@Override
	public void setDocument(Document document) {
		this.document = document;
		for (Item subItem : this.subItems)
			subItem.setDocument(document);		
	}
	
	public List<Item> getAll(boolean recursive){
		List<Item> result = new ArrayList<>();
		
		for (Item item : subItems){
			result.add(item);
			
			if (recursive)
				result.addAll(item.getAll(recursive));
		}
		
		return result;
	}
	
	public List<Item> getAll(Predicate<Item> predicate, boolean recursive){
		List<Item> result = new ArrayList<>();
		
		for (Item item : subItems){
			if (predicate.test(item))
				result.add(item);
			if (recursive)
				result.addAll(item.getAll(predicate, recursive));
		}
		
		return result;
	}
	
	public void forEach(Consumer<? super Item> action, boolean recursive){

		for (Item item : subItems){
			action.accept(item);
				
			if (recursive)
				item.forEach(action, recursive);
		}
	}
}
