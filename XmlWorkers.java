package ru.grandsmeta.document.impl.xml;

import ru.grandsmeta.document.Document;
import ru.grandsmeta.document.DocumentType;

public class XmlWorkers extends XmlFolder {

	public XmlWorkers(Document document) {
		super(document, Consts.T_WORKERS);
	}
	
	@Override
	protected boolean needToSave() {
		return getDocument().getDocumentType() == DocumentType.dtPrice;
	}

}
