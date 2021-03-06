/**
 * Copyright 1999-2015 dangdang.com.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */

package com.dangdang.ddframe.rdb.sharding.metrics;

import com.dangdang.ddframe.rdb.sharding.threadlocal.ThreadLocalObjectRepository;
import org.junit.Test;

import com.codahale.metrics.Timer.Context;

public final class MetricsContextTest {
    
    @Test
    public void assertMetricsContextEnable() {
        run(true);
    }
    
    @Test
    public void assertMetricsContextDisable() {
        run(false);
    }
    
    private void run(final boolean enable) {
        if(enable){
            ThreadLocalObjectRepository repository = new ThreadLocalObjectRepository();
            repository.addItem(new MetricsContext(1000000L, "example"));
            repository.open();
        }
        Context context = MetricsContext.start("example");
        MetricsContext.stop(context);
    }
}
