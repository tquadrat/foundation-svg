/*
 * ============================================================================
 *  Copyright © 2002-2020 by Thomas Thrien.
 *  All Rights Reserved.
 * ============================================================================
 *  Licensed to the public under the agreements of the GNU Lesser General Public
 *  License, version 3.0 (the "License"). You may obtain a copy of the License at
 *
 *       http://www.gnu.org/licenses/lgpl.html
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 *  WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 *  License for the specific language governing permissions and limitations
 *  under the License.
 */

package org.tquadrat.foundation.svg.helper;

import static org.tquadrat.foundation.xml.builder.XMLElement.Flags.ALLOWS_CHILDREN;
import static org.tquadrat.foundation.xml.builder.XMLElement.Flags.ALLOWS_TEXT;

import org.tquadrat.foundation.annotation.ClassVersion;
import org.tquadrat.foundation.svg.SVGElementAdapter;

/**
 *  An SVG class that may be the parent for each other SVG object; it is used
 *  for testing purposes only.
 *
 *  @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
 *  @version $Id: SVGDummyContainer.java 820 2020-12-29 20:34:22Z tquadrat $
 */
@ClassVersion( sourceVersion = "$Id: SVGDummyContainer.java 820 2020-12-29 20:34:22Z tquadrat $" )
public class SVGDummyContainer extends SVGElementAdapter
{
        /*--------------*\
    ====** Constructors **=====================================================
        \*--------------*/
    /**
     *  Creates an new instance for {@code SVGDummyContainer}.
     *
     *  @param  elementName The element name for the new element.
     */
    public SVGDummyContainer( final String elementName )
    {
        super( elementName, ALLOWS_CHILDREN, ALLOWS_TEXT );
    }   //  SVGDummyContainer()

    /**
     *  Creates an new instance for {@code SVGDummyContainer} with the element
     *  name '{@code DUMMY}'.
     */
    public SVGDummyContainer()
    {
        this( "DUMMY" );
    }   //  SVGDummyContainer()
}
//  class SVGDummyContainer

/*
 *  End of File
 */