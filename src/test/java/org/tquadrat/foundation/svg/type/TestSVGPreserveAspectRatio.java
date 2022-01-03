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
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.tquadrat.foundation.annotation.ClassVersion;
import org.tquadrat.foundation.svg.helper.SVGTestBase;

/**
 *  Tests for the class
 *  {@link SVGPreserveAspectRatio}.
 *
 *  @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
 *  @version $Id: TestSVGPreserveAspectRatio.java 820 2020-12-29 20:34:22Z tquadrat $
 *  @since 0.0.5
 */
@ClassVersion( sourceVersion = "$Id: TestSVGPreserveAspectRatio.java 820 2020-12-29 20:34:22Z tquadrat $" )
@DisplayName( "org.tquadrat.foundation.svg.type.TestSVGPreserveAspectRatio" )
public class TestSVGPreserveAspectRatio extends SVGTestBase
{
        /*---------*\
    ====** Methods **==========================================================
        \*---------*/
    /**
     *  Calls the methods of
     *  {@link SVGPreserveAspectRatio}
     *  to reach the test coverage ratio.
     */
    @Test
    final void cover()
    {
        skipThreadTest();

        for( final var value : SVGPreserveAspectRatio.values() )
        {
            assertNotNull( value.toString() );
            final var valueName = value.name();
            assertNotEquals( valueName, value.toString() );
            assertNotNull( SVGPreserveAspectRatio.valueOf( valueName ) );
            assertEquals( value, SVGPreserveAspectRatio.valueOf( valueName ) );
        }
    }   //  cover()
}
//  class TestSVGPreserveAspectRatio

/*
 *  End of File
 */