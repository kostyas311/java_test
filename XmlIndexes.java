package ru.grandsmeta.document.impl.xml;

import ru.grandsmeta.document.Document;
import ru.grandsmeta.document.DocumentType;

public class XmlIndexes extends XmlContainer {

	public XmlIndexes(Document document) {
		super(document, Consts.T_INDEXES);
	}

	@Override
	protected XmlItem newItem(String xmlTag) {
		switch (xmlTag){
		case Consts.T_FOLDER:
				return new XmlFolder(getDocument());
		case Consts.T_INDEX:
				return new XmlIndex(getDocument());
		default:
			return null;
		}
	}

	@Override
	protected boolean needToSave() {
		return getDocument().getDocumentType() == DocumentType.dtIndex;
	}
}
