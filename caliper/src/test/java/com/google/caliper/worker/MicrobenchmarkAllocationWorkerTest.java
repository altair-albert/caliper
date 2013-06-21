/*
 * Copyright (C) 2013 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.caliper.worker;

import static org.junit.Assert.assertEquals;


import com.google.caliper.legacy.Benchmark;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Tests {@link MicrobenchmarkAllocationWorker}.
 */
@RunWith(JUnit4.class)
public class MicrobenchmarkAllocationWorkerTest {
  @Test public void findMethod() throws Exception {
    assertEquals(TestBenchmark.class.getMethod("timeLongArg", long.class),
        MicrobenchmarkAllocationWorker.findMethod(TestBenchmark.class, "timeLongArg"));
    assertEquals(TestBenchmark.class.getMethod("timeIntArg", int.class),
        MicrobenchmarkAllocationWorker.findMethod(TestBenchmark.class, "timeIntArg"));
  }

  public static final class TestBenchmark extends Benchmark {
    public void timeLongArg(long reps) {}
    public void timeIntArg(int reps) {}
  }
}