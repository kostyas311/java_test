package ru.grandsmeta.document.impl.xml;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import ru.grandsmeta.document.Cost;
import ru.grandsmeta.document.CostType;
import ru.grandsmeta.document.Document;
import ru.grandsmeta.document.Element;
import ru.grandsmeta.document.Item;

public class XmlCost extends XmlItem implements Cost {

	public XmlCost(Document document, String xmlTag) {
		super(document, xmlTag);

		String stringValue = "0";

		for (int i = 0; i < getMaxZoneNumber(); i++)
			stringValue += " 0";

		setAttrib(Consts.A_VALUE, stringValue);
	}

	public XmlCost(Document document, CostType type) {
		this(document, Consts.getXmlName(type));
	}

	@Override
	public double getValue(int zone) {
		if (isZoneSupported(zone) && !isCommonValue()) {
			String[] costValues = getAttrib(Consts.A_VALUE).split(" ");
			return Double.parseDouble(costValues[zone].replace(",","."));
		} else
			return 0;
	}

	private int getMaxZoneNumber() {
		int result = -1;
		Item zones = getDocument().getZones();
		try {
			for (int i = 0; i < zones.count(); i++) {
				Element zone = (Element) zones.getItem(i);
				int number = Integer.parseInt(zone.getCode());
				if (number > result)
					result = number;
			}
		} catch (NumberFormatException e) {
			result = zones.count();
		}

		return result;
	}

	@Override
	public void setValue(int zone, double value) {
		if (isZoneSupported(zone)) {
			String[] costValues = getAttrib(Consts.A_VALUE).split(" ");

			int maxZoneNumber = getMaxZoneNumber();

			if (costValues.length != maxZoneNumber + 1) {
				String[] newCostValue = new String[maxZoneNumber + 1];
				Arrays.fill(newCostValue, "0");

				for (int i = 0; i < costValues.length; i++)
					if (costValues[i] == null)
						newCostValue[i + 1] = "0";
					else
						newCostValue[i + 1] = costValues[i];
				costValues = newCostValue;
			}

			costValues[zone] = Double.toString(value);

			String updatedValue = "";
			for (String zonedValue : costValues)
				updatedValue += zonedValue + " ";
			setAttrib(Consts.A_VALUE, updatedValue);
		}
	}

	@Override
	public CostType getType() {
		switch (getXMLTag()) {
		case Consts.T_PZ:
			return CostType.cstPZ;

		case Consts.T_OZ:
			return CostType.cstOZ;

		case Consts.T_EM:
			return CostType.cstEM;

		case Consts.T_ZM:
			return CostType.cstZM;

		case Consts.T_MT:
			return CostType.cstMT;

		case Consts.T_WSP:
			return CostType.cstWSP;

		case Consts.T_TZ:
			return CostType.cstTZ;

		case Consts.T_TZM:
			return CostType.cstTZM;

		case Consts.T_COUNT:
			return CostType.cstCount;

		case Consts.T_MASS:
			return CostType.cstMass;

		case Consts.T_PRICE:
			return CostType.cstPrice;

		case Consts.T_PRICEBT:
			return CostType.cstPriceBT;

		case Consts.T_PRICEA:
			return CostType.cstPriceA;

		case Consts.T_PRICEB:
			return CostType.cstPriceB;

		default:
			return null;
		}
	}

	@Override
	protected Set<String> getAttribs() {
		Set<String> attribs = new HashSet<>();
		attribs.add("Value");
		return attribs;
	}

	@Override
	protected XmlItem newItem(String xmlTag) {
		return null;
	}

	@Override
	public boolean isZoneSupported(int zone) {
		Item zones = getDocument().getZones();
		boolean result = false;
		for (int i = 0; i < zones.count(); i++) {
			Element element = (Element) zones.getItem(i);
			if (element.getCode().equals(Integer.toString(zone))) {
				result = true;
				break;
			}

		}
		return result || (zone <= zones.count()) && (zone > 0);
	}

	@Override
	public boolean isCommonValue() {
		return !getAttrib(Consts.A_VALUE).contains(" ");
	}

	@Override
	public void setCommonValue(double value) {
		setAttrib(Consts.A_VALUE, Double.toString(value));
	}

	@Override
	protected boolean needToSave() {
		String attribValue = getAttrib(Consts.A_VALUE);

		String[] values = attribValue.split(" ");

		for (int i = 0; i < values.length; i++)
			if (Double.parseDouble(values[i].replace(",", ".")) != 0)
				return true;

		return false;

	}

}
