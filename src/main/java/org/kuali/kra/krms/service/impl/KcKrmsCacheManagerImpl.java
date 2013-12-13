/*
 * Copyright 2005-2013 The Kuali Foundation
 * 
 * Licensed under the Educational Community License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.opensource.org/licenses/ecl1.php
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kuali.kra.krms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.kuali.kra.krms.service.KcKrmsCacheManager;
import org.kuali.rice.core.api.cache.CacheAdminService;
import org.kuali.rice.core.api.cache.CacheTarget;
import org.kuali.rice.krms.api.repository.agenda.AgendaDefinition;
import org.kuali.rice.krms.api.repository.proposition.PropositionDefinition;
import org.kuali.rice.krms.api.repository.rule.RuleDefinition;

public class KcKrmsCacheManagerImpl implements KcKrmsCacheManager {
    private CacheAdminService krmsDistributedCacheManager;
    static final List<CacheTarget> cacheTargets= new ArrayList<CacheTarget>();
    static{
        cacheTargets.add(CacheTarget.entireCache(AgendaDefinition.Cache.NAME));
        cacheTargets.add(CacheTarget.entireCache(RuleDefinition.Cache.NAME));
        cacheTargets.add(CacheTarget.entireCache(PropositionDefinition.Cache.NAME));
    }
    @Override
    public void clearCache() {
        if(krmsDistributedCacheManager!=null){
            krmsDistributedCacheManager.flush(cacheTargets);   
        }
    }
    /**
     * Gets the krmsDistributedCacheManager attribute. 
     * @return Returns the krmsDistributedCacheManager.
     */
    public CacheAdminService getKrmsDistributedCacheManager() {
        return krmsDistributedCacheManager;
    }
    /**
     * Sets the krmsDistributedCacheManager attribute value.
     * @param krmsDistributedCacheManager The krmsDistributedCacheManager to set.
     */
    public void setKrmsDistributedCacheManager(CacheAdminService krmsDistributedCacheManager) {
        this.krmsDistributedCacheManager = krmsDistributedCacheManager;
    }

}
