package com.silanis.esl.sdk.examples;

import com.silanis.esl.sdk.internal.HttpRequestUtil;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;

/**
 * Created by schoi on 1/23/15.
 */
public class StartFastTrackExampleTest {
    @Test
    public void verifyResult() {
        StartFastTrackExample example = new StartFastTrackExample(Props.get());
        example.run();

        assertThat("Signing URL for Signer 1 is not returned.", example.signingUrl, is(not(isEmptyOrNullString())));
        String stringResponse1 = HttpRequestUtil.getUrlContent(example.signingUrl);
        assertThat(stringResponse1, containsString("Electronic Disclosures and Signatures Consent"));
    }
}