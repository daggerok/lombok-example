package daggerok;

import daggerok.extensions.CaptureSystemOutput;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Slf4j
@CaptureSystemOutput
@DisplayName("Ololo app JUnit 5 tests")
class AppOloloJUnit5Test {

  @Test
  @DisplayName("test using outputCapture.expect")
  void testUsingOutputCaptureExpect(final CaptureSystemOutput.OutputCapture outputCapture) {
    outputCapture.expect((containsString("ololo")));
    App.main(new String[] {});
  }

  @Test
  @DisplayName("test using regular assert matcher")
  void testUsingRegularAssertMatcher(final CaptureSystemOutput.OutputCapture outputCapture) {
    App.main(new String[] {});
    assertThat(outputCapture.toString(), containsString("ololo"));
  }
}
