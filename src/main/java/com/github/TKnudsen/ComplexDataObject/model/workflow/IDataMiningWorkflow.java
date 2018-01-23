package com.github.TKnudsen.ComplexDataObject.model.workflow;

import java.util.List;
import java.util.function.Function;

import com.github.TKnudsen.ComplexDataObject.data.features.AbstractFeatureVector;
import com.github.TKnudsen.ComplexDataObject.data.features.Feature;
import com.github.TKnudsen.ComplexDataObject.data.interfaces.IDObject;
import com.github.TKnudsen.ComplexDataObject.model.distanceMeasure.IIDObjectDistanceMeasure;
import com.github.TKnudsen.ComplexDataObject.model.processors.IDataProcessor;
import com.github.TKnudsen.ComplexDataObject.model.processors.features.IFeatureVectorProcessor;
import com.github.TKnudsen.ComplexDataObject.model.transformations.descriptors.IDescriptor;

/**
 * <p>
 * Title: IDataMiningWorkflow
 * </p>
 * 
 * <p>
 * Description:
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2016
 * </p>
 * 
 * @author Juergen Bernard
 */
public interface IDataMiningWorkflow<O extends IDObject, F, FV extends AbstractFeatureVector<F, ? extends Feature<F>>, PP extends IDataProcessor<? super O>, DESC extends IDescriptor<? super O, F, FV>> extends Function<List<O>, List<FV>> {

	public void addPreProcessor(PP processor);

	public void setDescriptor(DESC descriptor);

	public IIDObjectDistanceMeasure<FV> getDistanceMeasure();

	public void setDistanceMeasure(IIDObjectDistanceMeasure<FV> distanceMeasure);

	public void addFeatureProcessor(IFeatureVectorProcessor<FV> featureProcessor);
}
