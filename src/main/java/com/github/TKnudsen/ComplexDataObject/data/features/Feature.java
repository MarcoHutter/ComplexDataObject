package com.github.TKnudsen.ComplexDataObject.data.features;

import java.io.Serializable;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * <p>
 * Title: Feature
 * </p>
 *
 * <p>
 * Description: Representation of a single feature consisting of its name and
 * its value.
 * </p>
 *
 * <p>
 * Copyright: Copyright (c) 2016
 * </p>
 *
 * @author Juergen Bernard
 * @version 1.0
 */
public abstract class Feature<V extends Object> implements Comparable<Feature<V>>, Map.Entry<String, V>, Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 921823756506274008L;

	/**
	 * The name/key/identifier/attribute/column of the feature. Needs to be
	 * comparable.
	 */

	protected String featureName;

	/**
	 * The value of the feature
	 */

	protected V featureValue;

	/**
	 * The type of feature. Default: FeatureType.Double
	 */
	protected FeatureType featureType = FeatureType.DOUBLE;

	
	protected Feature(FeatureType featureType) {
		this.featureType = featureType;
	}
	
	/**
	 *
	 * @param featureName
	 * @param featureValue
	 */
	public Feature(String featureName, V featureValue) {
		this(featureName, featureValue, FeatureType.DOUBLE);
	}

	public Feature(String featureName, V featureValue, FeatureType featureType) {
		this.featureName = featureName;
		this.featureValue = featureValue;
		this.featureType = featureType;
	}

	public String getFeatureName() {
		return featureName;
	}

	public void setFeatureName(String featureName) {
		this.featureName = featureName;
	}

	public V getFeatureValue() {
		return featureValue;
	}

	public boolean setFeatureValue(V featureValue) {
		this.featureValue = featureValue;
		return true;
	}

	/**
	 * return the type of feature. Default: DOUBLE
	 *
	 * @return
	 */
	public FeatureType getFeatureType() {
		return featureType;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int compareTo(Feature<V> o) {
		int c = featureName.compareTo(o.getKey());
		if (c == 0 && featureValue instanceof Comparable<?> && o.getValue() instanceof Comparable<?>)
			return ((Comparable<Feature<?>>) featureValue).compareTo((Feature<?>) o.getFeatureValue());
		return featureName.compareTo(o.getKey());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		Feature<?> other = (Feature<?>) obj;

		if (!featureName.equals(other.featureName))
			return false;

		if (!featureValue.equals(other.featureValue))
			return false;

		if (!featureType.equals(other.featureType))
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = 1;

		result = 29 * result + featureName.hashCode();
		if (featureValue != null && !Double.isNaN(featureValue.hashCode()))
			result = 29 * result + featureValue.hashCode();

		return result;
	}

	@Override
	public abstract Feature<V> clone();

	@Override
	public String toString() {
		return "Feature " + featureName + ": " + featureValue + " (" + featureType.name() + ") ";
	}

	@Override
	public String getKey() {
		return getFeatureName();
	}

	@Override
	public V getValue() {
		return getFeatureValue();
	}

	@Override
	public V setValue(V arg0) {
		this.setFeatureValue(arg0);
		return arg0;
	}
	
	
}
