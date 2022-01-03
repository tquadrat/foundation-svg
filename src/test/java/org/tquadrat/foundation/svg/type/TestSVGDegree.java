/*
 * ============================================================================
 * Copyright © 2002-2020 by Thomas Thrien.
 * All Rights Reserved.
 * ============================================================================
 * Licensed to the public under the agreements of the GNU Lesser General Public
 * License, version 3.0 (the "License"). You may obtain a copy of the License at
 *
 *      http://www.gnu.org/licenses/lgpl.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package org.tquadrat.foundation.svg.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.tquadrat.foundation.annotation.ClassVersion;
import org.tquadrat.foundation.svg.helper.SVGTestBase;
import org.tquadrat.foundation.svg.type.SVGNumber.SVGDegree;

/**
 *  Tests for the class
 *  {@link SVGNumber.SVGDegree}.
 *
 *  @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
 *  @version $Id: TestSVGDegree.java 820 2020-12-29 20:34:22Z tquadrat $
 *  @since 0.0.5
 */
@SuppressWarnings( "MisorderedAssertEqualsArguments" )
@ClassVersion( sourceVersion = "$Id: TestSVGDegree.java 820 2020-12-29 20:34:22Z tquadrat $" )
@DisplayName( "org.tquadrat.foundation.svg.type.TestSVGDegree" )
public class TestSVGDegree extends SVGTestBase
{
        /*---------*\
    ====** Methods **==========================================================
        \*---------*/
    /**
     *  Tests for the class
     *  {@link SVGDegree}.
     */
    @Test
    final void testSVGDegree()
    {
        skipThreadTest();

        SVGDegree candidate;

        String actual, expected;

        candidate = new SVGDegree( 12 );
        assertNotNull( candidate );
        expected = "12";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = new SVGDegree( 372 );
        assertNotNull( candidate );
        expected = "12";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = new SVGDegree( 12.0 );
        assertNotNull( candidate );
        expected = "12.000";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = new SVGDegree( 372.0 );
        assertNotNull( candidate );
        expected = "12.000";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testSVGDegree()
}
//  class TestSVGDegree

/*
 *  End of File
 */