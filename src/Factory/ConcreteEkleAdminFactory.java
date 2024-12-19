package Factory;

import Model.ekleAdminModel;

public class ConcreteEkleAdminFactory implements ekleAdminFactory {

    @Override
    public ekleAdminModel createekleAdminModel() {

        return new ekleAdminModel();
    }
}
