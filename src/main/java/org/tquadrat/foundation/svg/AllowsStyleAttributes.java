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

package org.tquadrat.foundation.svg;

import static org.apiguardian.api.API.Status.STABLE;
import static org.tquadrat.foundation.svg.SVGUtils.SVGATTRIBUTE_Class;
import static org.tquadrat.foundation.svg.SVGUtils.SVGATTRIBUTE_Style;

import java.util.List;

import org.apiguardian.api.API;
import org.tquadrat.foundation.annotation.ClassVersion;

/**
 *  SVG elements that allow the style attributes
 *  {@value SVGUtils#SVGATTRIBUTE_Class} and
 *  {@value SVGUtils#SVGATTRIBUTE_Style}
 *  will implement this interface.
 *
 *  @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
 *  @version $Id: AllowsStyleAttributes.java 820 2020-12-29 20:34:22Z tquadrat $
 *  @since 0.0.5
 *
 *  @UMLGraph.link
 */
@ClassVersion( sourceVersion = "$Id: AllowsStyleAttributes.java 820 2020-12-29 20:34:22Z tquadrat $" )
@API( status = STABLE, since = "0.0.5" )
public sealed interface AllowsStyleAttributes
    permits SVG, SVGGroup, SVGLine, SVGPath, SVGRectangle, SVGSymbol, SVGTSpan, SVGText
{
        /*------------------------*\
    ====** Static Initialisations **===========================================
        \*------------------------*/
    /**
     *  The core attributes.
     */
    public static final List<String> STYLE_ATTRIBUTES = List.of( SVGATTRIBUTE_Class, SVGATTRIBUTE_Style );

        /*---------*\
    ====** Methods **==========================================================
        \*---------*/
    /**
     *  Sets the CSS class for the SVG element.
     *
     *  @param  value   The name of a CSS class for this SVG element.
     */
    public void setClass( final CharSequence value );

    /**
     *  Sets the CSS style for the SVG element.
     *
     *  @param  value   A CSS style definition.
     */
    public void setStyle( final CharSequence value );
}
//  interface AllowsStyleAttributes

/*
 *  End of File
 */