/*
 * Copyright (C) 2000 - 2014 Silverpeas
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * As a special exception to the terms and conditions of version 3.0 of
 * the GPL, you may redistribute this Program in connection with Free/Libre
 * Open Source Software ("FLOSS") applications as described in Silverpeas's
 * FLOSS exception. You should have recieved a copy of the text describing
 * the FLOSS exception, and it is also available here:
 * "http://www.silverpeas.org/docs/core/legal/floss_exception.html"
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.silverpeas.test;

/**
 * This builder extends the {@link WarBuilder} in order to centralize the
 * definition of common archive part definitions.
 */
public class WarBuilder4WarCore extends WarBuilder<WarBuilder4WarCore> {

  /**
   * Constructs a war builder for the specified test class. It will load all the resources in the
   * same packages of the specified test class.
   * @param test the class of the test for which a war archive will be build.
   */
  protected <T> WarBuilder4WarCore(final Class<T> test) {
    super(test);
  }

  /**
   * Gets an instance of a war archive builder for the specified test class with the
   * following common stuffs:
   * <ul>
   * <li>ws-test-core</li>
   * <li>lib-core</li>
   * <li>all the necessary to handle http request ({@link org.silverpeas.servlet.HttpRequest} for example)</li>
   * </ul>
   * @return the instance of the war archive builder.
   */
  public static <T> WarBuilder4WarCore onWarForTestClass(Class<T> test) {
    WarBuilder4WarCore warBuilder = new WarBuilder4WarCore(test);
    warBuilder.addMavenDependencies("javax.jcr:jcr");
    warBuilder.addMavenDependenciesWithPersistence("org.silverpeas.core:lib-core");
    warBuilder.addMavenDependenciesWithPersistence("org.silverpeas.core.ejb-core:pdc");
    warBuilder.addMavenDependenciesWithPersistence("org.silverpeas.core.ejb-core:node");
    warBuilder.addMavenDependenciesWithPersistence("org.silverpeas.core:web-core");
    warBuilder.addMavenDependencies("org.silverpeas.core.ejb-core:comment");
    warBuilder.addMavenDependencies("org.silverpeas.core.ejb-core:personalization");
    warBuilder.addMavenDependencies("org.silverpeas.core.ejb-core:clipboard");
    warBuilder.addMavenDependencies("org.silverpeas.core.ejb-core:statistic");
    warBuilder.addMavenDependencies("org.silverpeas.core.ejb-core:silverstatistics");
    warBuilder.addMavenDependencies("org.silverpeas.core.ejb-core:searchengine");
    warBuilder.addMavenDependencies("org.silverpeas.core.ejb-core:formtemplate");
    warBuilder.addMavenDependencies("org.silverpeas.core.ejb-core:publication");
    warBuilder.addMavenDependencies("org.silverpeas.core.ejb-core:calendar");
    warBuilder.addMavenDependencies("org.silverpeas.core.ejb-core:contact");
    warBuilder.addMavenDependencies("org.silverpeas.core.ejb-core:mylinks");
    warBuilder.addMavenDependencies("org.silverpeas.core.ejb-core:importExport");
    warBuilder.addMavenDependencies("org.silverpeas.core.ejb-core:tagcloud");
    warBuilder.addMavenDependencies("org.apache.tika:tika-core");
    warBuilder.addMavenDependencies("org.apache.tika:tika-parsers");
    warBuilder.addAsResource("META-INF/test-MANIFEST.MF", "META-INF/MANIFEST.MF");
    return warBuilder;
  }

}