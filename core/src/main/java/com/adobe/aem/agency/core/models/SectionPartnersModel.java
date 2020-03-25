package com.adobe.aem.agency.core.models;

import com.adobe.aem.agency.core.entities.Partner;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.ArrayList;

@Model(adaptables = Resource.class)
public class SectionPartnersModel {

    @Inject
    @Optional
    protected String title;

    @Inject
    @Optional
    protected String text;

    @Inject
    @Optional
    protected Resource partners;

    private ArrayList<Partner> items = new ArrayList<>();

    @PostConstruct
    protected void init() {
        if (partners != null && partners.hasChildren()) {
            for (Resource item : partners.getChildren()) {
                ValueMap vm = item.getValueMap();
                Partner partner = new Partner();
                partner.setImage(vm.containsKey("partnerLogo") ? vm.get("partnerLogo", String.class) : null);
                partner.setAltText(vm.containsKey("imageAlt") ? vm.get("imageAlt", String.class) : null);
                partner.setPath(vm.containsKey("page") ? vm.get("page", String.class) : null);
                items.add(partner);
            }
        }
    }

    public ArrayList<Partner> getItems() {
        return items;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
