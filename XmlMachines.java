package ru.grandsmeta.document.impl.xml;

import ru.grandsmeta.document.Document;
import ru.grandsmeta.document.DocumentType;

public class XmlMachines extends XmlFolder {

	public XmlMachines(Document document) {
		super(document, Consts.T_MACHINES);
	}
	
	@Override
	protected boolean needToSave() {
		return getDocument().getDocumentType() == DocumentType.dtPrice;
	}
}
