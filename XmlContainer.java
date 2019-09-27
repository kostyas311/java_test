package ru.grandsmeta.document.impl.xml;

import java.util.HashSet;
import java.util.Set;

import ru.grandsmeta.document.Document;

public abstract class XmlContainer extends XmlItem {

	public XmlContainer(Document document, String xmlTag) {
		super(document, xmlTag);
	}

	@Override
	protected Set<String> getAttribs() {
		Set<String> attribs = new HashSet<>();
		attribs.add(Consts.A_CHAPTER_CAPTION);
		
		return attribs;
	}

	@Override
	abstract protected XmlItem newItem(String xmlTag);
	
	public String getCaption(){
		return getAttrib(Consts.A_CHAPTER_CAPTION);	
	}

	@Override
	abstract protected boolean needToSave();

}
