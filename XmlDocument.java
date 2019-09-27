package ru.grandsmeta.document.impl.xml;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.SAXException;

import ru.grandsmeta.document.BaseDataType;
import ru.grandsmeta.document.Document;
import ru.grandsmeta.document.DocumentType;
import ru.grandsmeta.document.Item;

public class XmlDocument extends XmlItem implements Document {

	private XmlItem chapters;
	private XmlItem indexes;
	private XmlItem zones;
	private XmlItem workers;
	private XmlItem machines;
	private XmlItem materials;
	private XmlItem mechanics;

	public XmlDocument() {
		super(null, Consts.T_DOCUMENT);
		this.chapters = new XmlChapters(this);
		this.zones = new XmlZones(this);
		this.indexes = new XmlIndexes(this);
		this.workers = new XmlWorkers(this);
		this.materials = new XmlMaterials(this);
		this.machines = new XmlMachines(this);
		this.mechanics = new XmlMechanincs(this);
		
		add(this.chapters);
		add(this.zones);
		add(this.indexes);
		add(this.workers);
		add(this.materials);
		add(this.machines);
		add(this.mechanics);
	}

	@Override
	protected Set<String> getAttribs() {
		Set<String> attribs = new HashSet<String>();

		attribs.add(Consts.A_DOCUMENT_DOCUMENTTYPE);
		attribs.add(Consts.A_DOCUMENT_NUMBER);
		attribs.add(Consts.A_DOCUMENT_TITLE);
		attribs.add(Consts.A_DOCUMENT_ID);
		attribs.add(Consts.A_DOCUMENT_YEAR);
		attribs.add(Consts.A_DOCUMENT_TYPENAME);
		attribs.add(Consts.A_DOCUMENT_TYPE);
		attribs.add(Consts.A_DOCUMENT_GUID);
		attribs.add(Consts.A_DOCUMENT_FLAGS);
		attribs.add(Consts.A_DOCUMENT_AREAOFAPP);
		attribs.add(Consts.A_DOCUMENT_COMMENT);

		return attribs;
	}

	@Override
	protected XmlItem newItem(String xmlTag) {
		switch (xmlTag) {
		case Consts.T_ZONES:
			return zones;
		case Consts.T_CHAPTERS:
			return chapters;
		case Consts.T_INDEXES:
			return indexes;
		case Consts.T_MACHINES:
			return this.machines;
		case Consts.T_MATERIALS:
			return this.materials;
		case Consts.T_MECHANICS:
			return this.mechanics;
		case Consts.T_WORKERS:
			return this.workers;
		default:
			return null;
		}
	}

	public DocumentType getDocumentType() {
		switch (getAttrib(Consts.A_DOCUMENT_DOCUMENTTYPE)) {
		case Consts.AV_DOCUMENT_DOCUMENTTYPE_BASE:
			return DocumentType.dtBaseData;

		case Consts.AV_DOCUMENT_DOCUMENTTYPE_INDEX:
			return DocumentType.dtIndex;

		case Consts.AV_DOCUMENT_DOCUMENTTYPE_PRICE:
			return DocumentType.dtPrice;

		default:
			return null;
		}
	}

	public String getNumber() {
		return getAttrib(Consts.A_DOCUMENT_NUMBER);
	}

	public String getTitle() {
		return getAttrib(Consts.A_DOCUMENT_TITLE);
	}

	public int getYear() {
		return Integer.parseInt(getAttrib(Consts.A_DOCUMENT_YEAR));
	}

	public String getID() {
		return getAttrib(Consts.A_DOCUMENT_ID);
	}

	public String getTypeName() {
		return getAttrib(Consts.A_DOCUMENT_TYPENAME);
	}

	public String getType() {
		return getAttrib(Consts.A_DOCUMENT_TYPE);
	}

	public int getFlags() {
		return Integer.parseInt(getAttrib(Consts.A_DOCUMENT_FLAGS));
	}

	public String getAreaOfApp() {
		return getAttrib(Consts.A_DOCUMENT_AREAOFAPP);
	}

	public String getComment() {
		return getAttrib(Consts.A_DOCUMENT_COMMENT);
	}

	public void setDocumentType(DocumentType type) {

		setAttrib(Consts.A_DOCUMENT_DOCUMENTTYPE, Consts.getXmlName(type));
	}

	public void setNumber(String value) {
		setAttrib(Consts.A_DOCUMENT_NUMBER, value);
	}

	public void setTitle(String value) {
		setAttrib(Consts.A_DOCUMENT_TITLE, value);
	}

	public void setYear(int value) {
		setAttrib(Consts.A_DOCUMENT_YEAR, Integer.toString(value));
	}

	public void setID(String value) {
		setAttrib(Consts.A_DOCUMENT_ID, value);
	}

	public void setTypeName(String value) {
		setAttrib(Consts.A_DOCUMENT_TYPENAME, value);
	}

	public void setType(String value) {
		setAttrib(Consts.A_DOCUMENT_TYPE, value);
	}

	public void setFlags(int value) {
		setAttrib(Consts.A_DOCUMENT_FLAGS, Integer.toString(value));
	}

	public void setAreaOfApp(String value) {
		setAttrib(Consts.A_DOCUMENT_AREAOFAPP, value);
	}

	public void setComment(String value) {
		setAttrib(Consts.A_DOCUMENT_COMMENT, value);
	}

	@Override
	public Item getChapters() {
		return chapters;
	}

	@Override
	public Item getZones() {
		return zones;
	}

	@Override
	public BaseDataType getBaseDataType() {
		switch (getAttrib(Consts.A_DOCUMENT_TYPE)) {
		case Consts.AV_DOCUMENT_TYPE_CARGO:
			return BaseDataType.bdtCargo;

		case Consts.AV_DOCUMENT_TYPE_ER:
			return BaseDataType.bdtERs;

		case Consts.AV_DOCUMENT_TYPE_ESN:
			return BaseDataType.bdtESNs;

		case Consts.AV_DOCUMENT_TYPE_MACHINES:
			return BaseDataType.bdtMachine;

		case Consts.AV_DOCUMENT_TYPE_MATERIALS:
			return BaseDataType.bdtMaterial;

		case Consts.AV_DOCUMENT_TYPE_PROJECT:
			return BaseDataType.bdtProject;

		case Consts.AV_DOCUMENT_TYPE_ROWS:
			return BaseDataType.bdtRows;

		case Consts.AV_DOCUMENT_TYPE_WORKERS:
			return BaseDataType.bdtWorkerScale;
		default:
			return null;
		}
	}

	@Override
	public void setBaseDataType(BaseDataType type) {
		setAttrib(Consts.A_DOCUMENT_TYPE, Consts.getXmlName(type));
	}

	@Override
	protected boolean needToSave() {
		return true;
	}

	@Override
	public Item getWorkers() {
		return this.workers;		
	}

	@Override
	public Item getMachines() {
		return this.machines;
	}

	@Override
	public Item getMaterials() {
		return this.materials;		
	}

	@Override
	public Item getMechanics() {
		return this.mechanics;		
	}
	
	private DocumentBuilder getDocumentBuilder() throws ParserConfigurationException{
		return DocumentBuilderFactory.newInstance().newDocumentBuilder();
	}
	
	public void save(String fileName) throws ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException{
		org.w3c.dom.Document document = getDocumentBuilder().newDocument();
		
		org.w3c.dom.Element documentElement = (org.w3c.dom.Element) document.createElement(Consts.T_DOCUMENT);
		document.appendChild(documentElement);
		doWriteXML((org.w3c.dom.Element) documentElement);
		
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		transformer.transform(new DOMSource(document), new StreamResult(new File(fileName)));
	}
	
	public void load(String fileName) throws ParserConfigurationException, SAXException, IOException{
		DocumentBuilder builder = getDocumentBuilder();
		org.w3c.dom.Document document = builder.parse(new File(fileName));
		
		doReadXML(document.getDocumentElement());	
	}
	@Override
	public void assign(Document document) {
		setDocumentType(document.getDocumentType());
		setBaseDataType(document.getBaseDataType());
		setAreaOfApp(document.getAreaOfApp());
		setComment(document.getComment());
		setFlags(document.getFlags());
		setNumber(document.getNumber());
		setTypeName(document.getTypeName());
		setTitle(document.getTitle());
		this.chapters.assign(document.getChapters());
		this.indexes.assign(document.getIndexes());
		this.zones.assign(document.getZones());
		this.machines.assign(document.getMachines());
		this.materials.assign(document.getMaterials());
		this.mechanics.assign(document.getMechanics());
		this.workers.assign(document.getWorkers());
	}

	@Override
	public Item getIndexes() {
		return this.indexes;
	}
}
