package uk.q3c.krail.option;

import java.io.Serializable;

/**
 * Created by David Sowerby on 09 Aug 2017
 */
public interface OptionPermissionVerifier extends Serializable {


    <T> boolean userHasPermission(OptionEditAction action, UserHierarchy hierarchy, int hierarchyRank, OptionKey<T> optionKey);
}
