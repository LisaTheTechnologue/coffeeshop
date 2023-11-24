package com.company.coffeeshop.bean;

import com.company.coffeeshop.entity.user.User;
import io.jmix.core.UnconstrainedDataManager;
import io.jmix.core.security.UserRepository;
import io.jmix.oidc.claimsmapper.ClaimsRolesMapper;
import io.jmix.oidc.usermapper.SynchronizingOidcUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MySynchronizingOidcUserMapper extends SynchronizingOidcUserMapper<User> {

    public MySynchronizingOidcUserMapper(UnconstrainedDataManager dataManager,
                                         UserRepository userRepository,
                                         ClaimsRolesMapper claimsRolesMapper) {
        super(dataManager, userRepository, claimsRolesMapper);

        //store role assignments in the database (false by default)
        setSynchronizeRoleAssignments(true);
    }

    @Override
    protected Class<User> getApplicationUserClass() {

        return User.class;
    }

    @Override
    protected void populateUserAttributes(OidcUser oidcUser, User jmixUser) {
        String userName = (String) oidcUser.getClaims().get("unique_name");
        if (jmixUser.getEmail()==null) {
            jmixUser.setUsername(userName);
            jmixUser.setFirstName(oidcUser.getGivenName());
            jmixUser.setLastName(oidcUser.getFamilyName());
            jmixUser.setEmail(userName);
        }
        log.info("USER NAME: " + jmixUser.getUsername());
    }


}