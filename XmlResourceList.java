package ru.grandsmeta.document.impl.xml;

import ru.grandsmeta.document.Document;
import ru.grandsmeta.document.DocumentType;
import ru.grandsmeta.document.Resource;

public class XmlResourceList extends XmlContainer {

	public XmlResourceList(Document document, String xmlTag) {
		super(document, xmlTag);
	}

	@Override
	protected XmlItem newItem(String xmlTag) {
		switch (xmlTag){
		case Consts.T_OUTLAY:
			return new XmlOutlay(getDocument());
		case Consts.T_RESOURCE:
			return new XmlResource(getDocument());
		default:
			return null;
		}
	}

	@Override
	protected boolean needToSave() {
		return getAll(item -> item instanceof Resource, true).size() > 0 && getDocument().getDocumentType() == DocumentType.dtBaseData;
	}

}
