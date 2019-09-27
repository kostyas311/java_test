package ru.grandsmeta.document.impl.xml;

import ru.grandsmeta.document.Document;
import ru.grandsmeta.document.DocumentType;

public class XmlMechanincs extends XmlFolder {

	public XmlMechanincs(Document document) {
		super(document, Consts.T_MECHANICS);
	}
	
	@Override
	protected boolean needToSave() {
		return getDocument().getDocumentType() == DocumentType.dtPrice;
	}
}
