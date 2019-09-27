package ru.grandsmeta.document.impl.xml;

import java.util.HashSet;
import java.util.Set;

import ru.grandsmeta.document.Cost;
import ru.grandsmeta.document.CostType;
import ru.grandsmeta.document.Document;
import ru.grandsmeta.document.DocumentType;
import ru.grandsmeta.document.Estimated;
import ru.grandsmeta.document.Item;
import ru.grandsmeta.document.Measured;
import ru.grandsmeta.document.Outlay;
import ru.grandsmeta.document.Resource;
import ru.grandsmeta.document.ResourceType;

public class XmlResource extends XmlItem implements Estimated, Measured, Resource {

	public XmlResource(Document document) {
		super(document, Consts.T_RESOURCE);
	}

	@Override
	public ResourceType getType() {
		switch (getAttrib(Consts.A_RESOURCE_TYPE)) {
		case Consts.AV_RESOURCE_TYPE_MACHINE:
			return ResourceType.rtMachine;

		case Consts.AV_RESOURCE_TYPE_MATERIAL:
			return ResourceType.rtMaterial;

		case Consts.AV_RESOURCE_TYPE_MACHINIST:
			return ResourceType.rtMechanic;

		case Consts.AV_RESOURCE_TYPE_WORKER:
			return ResourceType.rtWorker;

		default:
			return null;
		}
	}

	@Override
	public void setType(ResourceType type) {
		setAttrib(Consts.A_RESOURCE_TYPE, Consts.getXmlName(type));
	}

	@Override
	public Outlay getOutlay() {
		return (Outlay) getParent();
	}

	@Override
	public String getMeasure() {
		return getAttrib(Consts.A_ROW_MEASURE);
	}

	@Override
	public void setMeasure(String value) {
		setAttrib(Consts.A_ROW_MEASURE, value);
	}

	@Override
	public String getCode() {
		return getAttrib(Consts.A_ROW_NUMBER);
	}

	@Override
	public String getCaption() {
		return getAttrib(Consts.A_ROW_CAPTION);
	}

	@Override
	public void setCode(String code) {
		setAttrib(Consts.A_ROW_NUMBER, code);
	}

	@Override
	public void setCaption(String caption) {
		setAttrib(Consts.A_ROW_CAPTION, caption);
	}

	@Override
	public Cost getCost(CostType type) {
		for (int i = 0; i < this.count(); i++) {
			Item item = getItem(i);
			if (item instanceof Cost && ((Cost) item).getType() == type)
				return (Cost) item;
		}

		Cost result = new XmlCost(getDocument(), type);
		this.add((Item) result);

		return result;
	}

	@Override
	protected Set<String> getAttribs() {
		Set<String> attribs = new HashSet<>();

		attribs.add(Consts.A_ROW_NUMBER);
		attribs.add(Consts.A_ROW_CAPTION);
		attribs.add(Consts.A_ROW_MEASURE);
		attribs.add(Consts.A_RESOURCE_TYPE);
		attribs.add(Consts.A_ROW_WORKCLASS);

		return attribs;
	}

	@Override
	protected boolean needToSave() {
		return getDocument().getDocumentType() == DocumentType.dtBaseData;
	}

	@Override
	protected XmlItem newItem(String xmlTag) {
		switch (xmlTag) {
		case Consts.T_PRICE:
			return new XmlCost(getDocument(), CostType.cstPrice);

		case Consts.T_ZM:
			return new XmlCost(getDocument(), CostType.cstZM);

		case Consts.T_WSP:
			return new XmlCost(getDocument(), CostType.cstWSP);

		case Consts.T_MASS:
			return new XmlCost(getDocument(), CostType.cstMass);
		default:
			return null;
		}
	}
}
