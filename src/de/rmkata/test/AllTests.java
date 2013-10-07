package de.rmkata.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	DirectionTest.class,
	TestRover.class,
	TestPos.class
	})
public class AllTests {
}
