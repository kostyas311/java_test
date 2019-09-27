package ru.grandsmeta.document.impl.xml;

import ru.grandsmeta.document.Document;
import ru.grandsmeta.document.DocumentType;

public final class XmlZones extends XmlContainer {

	public XmlZones(Document document) {
		super(document, Consts.T_ZONES);
	}

	@Override
	protected XmlItem newItem(String xmlTag) {
		switch (xmlTag){
		case Consts.T_ZONE:
			return new XmlZone(getDocument());
		default:
			return null;
		}
	}

	@Override
	protected boolean needToSave() {
		return getDocument().getDocumentType() == DocumentType.dtBaseData;
	}

}
