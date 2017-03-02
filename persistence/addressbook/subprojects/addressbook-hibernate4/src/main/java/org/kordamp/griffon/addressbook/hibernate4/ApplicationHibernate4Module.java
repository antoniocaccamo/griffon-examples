/*
 * Copyright 2016-2017 Andres Almiray
 *
 * This file is part of Griffon Examples
 *
 * Griffon Examples is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Griffon Examples is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Griffon Examples. If not, see <http://www.gnu.org/licenses/>.
 */
package org.kordamp.griffon.addressbook.hibernate4;

import griffon.core.injection.Module;
import griffon.inject.DependsOn;
import griffon.plugins.hibernate4.Hibernate4Bootstrap;
import org.codehaus.griffon.runtime.core.injection.AbstractModule;
import org.kordamp.griffon.addressbook.ContactRepository;
import org.kordamp.jipsy.ServiceProviderFor;

import javax.inject.Named;

@DependsOn("application")
@Named("application-hibernate4")
@ServiceProviderFor(Module.class)
public class ApplicationHibernate4Module extends AbstractModule {
    @Override
    protected void doConfigure() {
        bindContactRepository();
        bindHibernate4Bootstrap();
    }

    private void bindContactRepository() {
        bind(ContactRepository.class)
            .to(Hibernate4ContactRepository.class)
            .asSingleton();
    }

    protected void bindHibernate4Bootstrap() {
        bind(Hibernate4Bootstrap.class)
            .to(ContactsHibernate4Bootstrap.class)
            .asSingleton();
    }
}