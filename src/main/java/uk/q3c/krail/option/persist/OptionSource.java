/*
 *
 *  * Copyright (c) 2016. David Sowerby
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 *  * the License. You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 *  * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 *  * specific language governing permissions and limitations under the License.
 *
 */

package uk.q3c.krail.option.persist;

import uk.q3c.krail.persist.PersistenceInfo;

import java.io.Serializable;
import java.lang.annotation.Annotation;

/**
 * Interface for a provider which identifies and returns the correct source for {@link OptionDaoDelegate} for Krail core, and returns an instance
 * <p>
 * Created by David Sowerby on 26/06/15.
 */
public interface OptionSource extends Serializable {

    OptionDaoDelegate getActiveDao();


    OptionDaoDelegate getDao(Class<? extends Annotation> annotationClass);

    PersistenceInfo getActivePersistenceInfo();


    PersistenceInfo getPersistenceInfo(Class<? extends Annotation> annotationClass);

    Class<? extends Annotation> getActiveSource();

    void setActiveSource(Class<? extends Annotation> activeSource);

}
