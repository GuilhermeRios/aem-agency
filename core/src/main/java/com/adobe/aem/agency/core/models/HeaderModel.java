package com.adobe.aem.agency.core.models;

import com.adobe.aem.agency.core.entities.MenuItem;
import com.adobe.aem.agency.core.entities.Slide;
import com.day.cq.dam.api.Asset;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.ArrayList;

@Model(adaptables = Resource.class)
public class HeaderModel {

    private Asset logoAsset;

    @Inject
    @Optional
    protected Resource imageReference;

    @Inject
    @Optional
    protected String alt;

    @Inject
    @Optional
    protected Resource path;

    @Inject
    @Optional
    protected Resource links;

    private ArrayList<MenuItem> items = new ArrayList<>();

    @PostConstruct
    protected void init() {
        if (imageReference != null) {
            setLogoAsset();
        }

        if (links != null && links.hasChildren()) {
            for (Resource item : links.getChildren()) {
                ValueMap vm = item.getValueMap();
                MenuItem menuItem = new MenuItem();
                menuItem.setTitle(vm.containsKey("title") ? vm.get("title", String.class) : null);
                menuItem.setPath(vm.containsKey("path") ? vm.get("path", String.class) : null);
                menuItem.setActive(false);
                items.add(menuItem);
            }
        }
    }

    private void setLogoAsset() {
        logoAsset = imageReference.adaptTo(Asset.class);
    }

    public ArrayList<MenuItem> getItems() {
        return items;
    }

    public String getLogo() {
        return logoAsset.getPath();
    }

    public String getAlt() {
        return alt;
    }

    public String getLogoPath() {
        return path.getPath();
    }
}
