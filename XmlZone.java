package ru.grandsmeta.document.impl.xml;

import java.util.HashSet;
import java.util.Set;

import ru.grandsmeta.document.Document;
import ru.grandsmeta.document.DocumentType;
import ru.grandsmeta.document.Element;

public class XmlZone extends XmlItem implements Element {

	public XmlZone(Document document) {
		super(document, Consts.T_ZONE);
		
	}

	@Override
	public String getCode() {
		
		return getAttrib(Consts.A_ZONE_CODE);
	}

	@Override
	public String getCaption() {
		
		return getAttrib(Consts.A_ZONE_CAPTION);
	}

	@Override
	public void setCode(String code) {
		
		setAttrib(Consts.A_ZONE_CODE, code);
	}

	@Override
	public void setCaption(String caption) {
		
		setAttrib(Consts.A_ZONE_CAPTION, caption);
	}

	@Override
	protected Set<String> getAttribs() {
		
		Set<String> attribs = new HashSet<String>();
		attribs.add(Consts.A_ZONE_CODE);
		attribs.add(Consts.A_ZONE_CAPTION);
		return attribs;
	}

	@Override
	protected XmlItem newItem(String xmlTag) {
		
		return null;
	}

	@Override
	protected boolean needToSave() {
		return this.getDocument().getDocumentType() == DocumentType.dtBaseData;
	}

}
