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

package org.tquadrat.foundation.svg.svgutils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.tquadrat.foundation.svg.SVGUtils.matrix;
import static org.tquadrat.foundation.svg.SVGUtils.rotate;
import static org.tquadrat.foundation.svg.SVGUtils.scale;
import static org.tquadrat.foundation.svg.SVGUtils.skewX;
import static org.tquadrat.foundation.svg.SVGUtils.skewY;
import static org.tquadrat.foundation.svg.SVGUtils.translate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.tquadrat.foundation.annotation.ClassVersion;
import org.tquadrat.foundation.svg.SVGUtils;
import org.tquadrat.foundation.svg.helper.SVGTestBase;

/**
 *  Tests for the methods
 *  {@link SVGUtils#matrix(long, long, long, long, long, long)},
 *  {@link SVGUtils#matrix(double, double, double, double, double, double)},
 *  {@link SVGUtils#rotate(long)},
 *  {@link SVGUtils#rotate(double)},
 *  {@link SVGUtils#rotate(long, long, long)},
 *  {@link SVGUtils#rotate(double, double, double)},
 *  {@link SVGUtils#scale(long)},
 *  {@link SVGUtils#scale(double)},
 *  {@link SVGUtils#scale(long, long)},
 *  {@link SVGUtils#scale(double, double)},
 *  {@link SVGUtils#skewX(long)},
 *  {@link SVGUtils#skewX(double)},
 *  {@link SVGUtils#skewY(long)},
 *  {@link SVGUtils#skewY(double)},
 *  {@link SVGUtils#translate(long)},
 *  {@link SVGUtils#translate(double)},
 *  {@link SVGUtils#translate(long, long)}
 *  and
 *  {@link SVGUtils#translate(double, double)}
 *  from the class
 *  {@link SVGUtils}.
 *
 *  @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
 *  @version $Id: TestTransformFactories.java 820 2020-12-29 20:34:22Z tquadrat $
 *  @since 0.0.5
 */
@SuppressWarnings( "MisorderedAssertEqualsArguments" )
@ClassVersion( sourceVersion = "$Id: TestTransformFactories.java 820 2020-12-29 20:34:22Z tquadrat $" )
@DisplayName( "org.tquadrat.foundation.svg.svgutils.TestTransformFactories" )
public class TestTransformFactories extends SVGTestBase
{
        /*---------*\
    ====** Methods **==========================================================
        \*---------*/
    /**
     *  Tests for the transform factory methods.
     */
    @Test
    final void testTransformFactories()
    {
        skipThreadTest();

        assertEquals( "matrix(1 1 1 1 1 1)", matrix( 1, 1, 1, 1, 1, 1 ).toString() );
        assertEquals( "matrix(1.000 1.000 1.000 1.000 1.000 1.000)", matrix( 1.0, 1.0, 1.0, 1.0, 1.0, 1.0 ).toString() );

        assertEquals( "rotate(1)", rotate( 1 ).toString() );
        assertEquals( "rotate(1.000)", rotate( 1.0 ).toString() );
        assertEquals( "rotate(1 1 1)", rotate( 1, 1, 1 ).toString() );
        assertEquals( "rotate(1.000 1.000 1.000)", rotate( 1.0, 1.0, 1.0 ).toString() );

        assertEquals( "scale(1)", scale( 1 ).toString() );
        assertEquals( "scale(1.000)", scale( 1.0 ).toString() );
        assertEquals( "scale(1 1)", scale( 1, 1 ).toString() );
        assertEquals( "scale(1.000 1.000)", scale( 1.0, 1.0 ).toString() );

        assertEquals( "skewX(1)", skewX( 1 ).toString() );
        assertEquals( "skewX(1.000)", skewX( 1.000 ).toString() );

        assertEquals( "skewY(1)", skewY( 1 ).toString() );
        assertEquals( "skewY(1.000)", skewY( 1.000 ).toString() );

        assertEquals( "translate(1)", translate( 1 ).toString() );
        assertEquals( "translate(1.000)", translate( 1.0 ).toString() );
        assertEquals( "translate(1 1)", translate( 1, 1 ).toString() );
        assertEquals( "translate(1.000 1.000)", translate( 1.0, 1.0 ).toString() );
    }   //  testTransformFactories()
}
//  class TestSVGUtils

/*
 *  End of File
 */