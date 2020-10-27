package seva.sahyog.sahashiksha.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class OrganizationList implements Serializable {

    private List<Organization> organizations = new ArrayList<>();

    public List<Organization> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(List<Organization> organizations) {
        this.organizations = organizations;
    }
}
