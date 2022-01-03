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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.tquadrat.foundation.lang.CommonConstants.EMPTY_STRING;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.tquadrat.foundation.annotation.ClassVersion;
import org.tquadrat.foundation.svg.helper.SVGTestBase;
import org.tquadrat.foundation.svg.type.SVGTransform.SVGSkewX;
import org.tquadrat.foundation.svg.type.SVGTransform.SVGSkewY;

/**
 *  Some test for the classes
 *  {@link SVGTransform}
 *  and its inner classes
 *  {@link SVGTransform.SVGMatrix},
 *  {@link SVGTransform.SVGRotate},
 *  {@link SVGTransform.SVGScale},
 *  {@link SVGTransform.SVGSkewX},
 *  {@link SVGTransform.SVGSkewY},
 *  and
 *  {@link SVGTransform.SVGTranslate}.
 *
 *  @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
 *  @version $Id: TestSVGTransform.java 820 2020-12-29 20:34:22Z tquadrat $
 *  @since 0.0.5
 */
@ClassVersion( sourceVersion = "$Id: TestSVGTransform.java 820 2020-12-29 20:34:22Z tquadrat $" )
@DisplayName( "org.tquadrat.foundation.svg.type.TestSVGTransform" )
public class TestSVGTransform extends SVGTestBase
{
        /*---------*\
    ====** Methods **==========================================================
        \*---------*/
    /**
     *  Satisfies the test coverage ratio.
     */
    @Test
    @SuppressWarnings( "unlikely-arg-type" )
    final void cover()
    {
        skipThreadTest();

        final var candidate = new SVGSkewX( 5 );
        final var otherCandidate = new SVGSkewX( 5 );

        //noinspection SimplifiableAssertion
        assertTrue( candidate.equals( candidate ) );
        //noinspection SimplifiableAssertion
        assertFalse( candidate.equals( null ) );
        //noinspection SimplifiableAssertion,EqualsBetweenInconvertibleTypes
        assertFalse( candidate.equals( EMPTY_STRING ) );
        //noinspection SimplifiableAssertion,EqualsBetweenInconvertibleTypes
        assertFalse( candidate.equals( new SVGSkewY( 5 ) ) );
        //noinspection SimplifiableAssertion
        assertFalse( candidate.equals( new SVGSkewX( 7 ) ) );
        //noinspection SimplifiableAssertion
        assertTrue( candidate.equals( otherCandidate ) );

        assertEquals( otherCandidate.hashCode(), candidate.hashCode() );
    }   //  cover()
}
//  class TestSVGTransform

/*
 *  End of File
 */