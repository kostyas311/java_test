package ru.grandsmeta.document.impl.xml;

import java.util.HashSet;
import java.util.Set;

import ru.grandsmeta.document.Cost;
import ru.grandsmeta.document.CostType;
import ru.grandsmeta.document.Document;
import ru.grandsmeta.document.Item;
import ru.grandsmeta.document.Outlay;
import ru.grandsmeta.document.OutlayOption;

public final class XmlOutlay extends XmlItem implements Outlay {

	public XmlOutlay(Document document) {
		super(document, Consts.T_OUTLAY);
	}

	@Override
	public Cost getCount() {
		for (int i = 0; i < this.count(); i++) {
			Item item = getItem(i);
			if (item instanceof Cost && ((Cost) item).getType() == CostType.cstCount)
				return (Cost) item;
		}
		
		Cost result = new XmlCost(getDocument(), CostType.cstCount);
		this.add((Item) result);
		
		return result;
	}

	@Override
	protected Set<String> getAttribs() {
		Set<String> attribs = new HashSet<>();
		attribs.add(Consts.A_OUTLAY_OPTIONS);
		return attribs;
	}

	@Override
	protected boolean needToSave() {
		return true;
	}

	@Override
	protected XmlItem newItem(String xmlTag) {
		switch (xmlTag){
		case Consts.T_COUNT:
			return new XmlCost(getDocument(), CostType.cstCount);
			
		case Consts.T_RESOURCE:
			return new XmlResource(getDocument());
		
		default:
			return null;
		}
	}

	@Override
	public boolean isChecked(OutlayOption option) {
		return getAttrib(Consts.A_OUTLAY_OPTIONS).contains(Consts.getXmlName(option));
	}

	@Override
	public void setOption(OutlayOption option, boolean value) {
		if (isChecked(option) == value)
			return;
		
		String attribValue = getAttrib(Consts.A_OUTLAY_OPTIONS);
		
		if (value)
			setAttrib(Consts.A_OUTLAY_OPTIONS, attribValue + " " + Consts.getXmlName(option));
		else{
			attribValue.replace(Consts.getXmlName(option), "");
			attribValue.replace("  ", " ");
			setAttrib(Consts.A_OUTLAY_OPTIONS, attribValue);
		}		
	}
}
