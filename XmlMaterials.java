package ru.grandsmeta.document.impl.xml;

import ru.grandsmeta.document.Document;
import ru.grandsmeta.document.DocumentType;

public class XmlMaterials extends XmlFolder {

	@Override
	protected boolean needToSave() {
		return getDocument().getDocumentType() == DocumentType.dtPrice;
	}


	public XmlMaterials(Document document) {
		super(document, Consts.T_MATERIALS);
	}
}

