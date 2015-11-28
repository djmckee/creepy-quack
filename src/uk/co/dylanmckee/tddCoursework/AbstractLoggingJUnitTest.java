package uk.co.dylanmckee.tddCoursework;

import org.junit.Rule;
import org.junit.ClassRule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;

import org.junit.runner.Description;

//using slf4j for logging tests - http://www.slf4j.org/manual.html
//with the logback backend - http://logback.qos.ch/
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractLoggingJUnitTest {

	static Logger logger = LoggerFactory.getLogger(AbstractLoggingJUnitTest.class);

	//http://thomassundberg.wordpress.com/2012/07/08/performing-an-action-when-a-test-fails/
	//http://stackoverflow.com/questions/9942825/how-to-tell-when-junit-finishes-by-just-using-a-testwatcher
	@Rule
	public final TestWatcher watchman = new TestWatcher()
	{
		@Override
        protected void starting(Description d) {
			AbstractLoggingJUnitTest.logger.trace("  Test [{}] starting ", d.getMethodName());
        }

        @Override
        protected void succeeded(Description d) {
			AbstractLoggingJUnitTest.logger.info("  Test [{}]   succeeded ", d.getMethodName());
        }

        @Override
        protected void failed(Throwable e, Description d) {
			AbstractLoggingJUnitTest.logger.warn("  Test [{}]   failed with exception [{}]", d.getMethodName(), e.getMessage());
        }

        @Override
        protected void finished(Description d) {
			AbstractLoggingJUnitTest.logger.trace("  Test [{}] finished ", d.getMethodName());
        }
	};
	
	@ClassRule
	public static TestRule classWatchman = new TestWatcher() {
		
		@Override
		protected void starting(Description d) {
			AbstractLoggingJUnitTest.logger.info("TestSuite [{}] started", d.getClassName());
		}
	    @Override
	    protected void finished(Description d) {
			AbstractLoggingJUnitTest.logger.info("TestSuite [{}] finished", d.getClassName());
	    }
	};
}
