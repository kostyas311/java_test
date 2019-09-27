package ru.grandsmeta.document.impl.xml;

import ru.grandsmeta.document.Document;
import ru.grandsmeta.document.DocumentType;
import ru.grandsmeta.document.Index;
import ru.grandsmeta.document.Price;

public class XmlFolder extends XmlContainer {

	public XmlFolder(Document document) {
		super(document, Consts.T_FOLDER);
	}
	
	public XmlFolder(Document document, String xmlTag) {
		super(document, xmlTag);
	}

	@Override
	protected XmlItem newItem(String xmlTag) {
		switch (xmlTag){
		case Consts.T_FOLDER:
				return new XmlFolder(getDocument());
		case Consts.T_INDEX:
				return new XmlIndex(getDocument());
		case Consts.T_ELEM:
				return new XmlPrice(getDocument());
		default:
			return null;
		}
	}

	@Override
	protected boolean needToSave() {
		
		return (getAll(item -> item instanceof Index || item instanceof Price, true).size() > 0) && 
				((getDocument().getDocumentType() == DocumentType.dtIndex) || (getDocument().getDocumentType() == DocumentType.dtPrice));
	}
}
