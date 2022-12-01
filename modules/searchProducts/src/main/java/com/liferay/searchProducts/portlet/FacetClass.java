package com.liferay.searchProducts.portlet;

import com.liferay.portal.kernel.search.BooleanClause;
import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.facet.collector.FacetCollector;
import com.liferay.portal.kernel.search.facet.config.FacetConfiguration;
import com.liferay.portal.kernel.search.facet.util.FacetValueValidator;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.search.facet.Facet;

public class FacetClass implements Facet {
    @Override
    public BooleanClause<Query> getFacetClause() {
        return null;
    }

    @Override
    public FacetCollector getFacetCollector() {
        return null;
    }

    @Override
    public FacetConfiguration getFacetConfiguration() {
        return null;
    }

    @Override
    public BooleanClause<Filter> getFacetFilterBooleanClause() {
        return null;
    }

    @Override
    public FacetValueValidator getFacetValueValidator() {
        return null;
    }

    @Override
    public String getFieldId() {
        return null;
    }

    @Override
    public String getFieldName() {
        return null;
    }

    @Override
    public SearchContext getSearchContext() {
        return null;
    }

    @Override
    public boolean isStatic() {
        return false;
    }

    @Override
    public void setFacetCollector(FacetCollector facetCollector) {

    }

    @Override
    public void setFacetConfiguration(FacetConfiguration facetConfiguration) {

    }

    @Override
    public void setFacetValueValidator(FacetValueValidator facetValueValidator) {

    }

    @Override
    public void setFieldName(String fieldName) {

    }

    @Override
    public void setStatic(boolean isStatic) {

    }

    @Override
    public String getAggregationName() {
        return null;
    }

    @Override
    public String[] getSelections() {
        return new String[0];
    }

    @Override
    public void select(String... selections) {

    }

    @Override
    public void setAggregationName(String aggregationName) {

    }
}
