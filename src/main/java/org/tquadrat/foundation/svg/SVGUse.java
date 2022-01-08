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

import org.apiguardian.api.API;
import org.tquadrat.foundation.annotation.ClassVersion;
import org.tquadrat.foundation.svg.type.SVGNumber;

/**
 *  The definition of the SVG element {@code <use>}. <br>
 *  <br>A {@code <use>} element is useless without the attribute {@code href}
 *  set; therefore it is required already on creation and will not appear in
 *  this interface.
 *
 *  @see SVGUtils#createUse(java.net.URI)
 *  @see SVGUtils#createUse(SVGElementWithChildren,java.net.URI)
 *
 *  @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
 *  @version $Id: SVGUse.java 980 2022-01-06 15:29:19Z tquadrat $
 *  @since 0.0.5
 *
 *  @see "https://www.w3.org/TR/SVG/single-page.html#struct-SVGElement"
 *
 *  @UMLGraph.link
 */
@ClassVersion( sourceVersion = "$Id: SVGUse.java 980 2022-01-06 15:29:19Z tquadrat $" )
@API( status = STABLE, since = "0.0.5" )
public sealed interface SVGUse extends SVGElement, AllowsConditionalProcessingAttributes, AllowsGraphicalEventAttributes, AllowsPresentationAttributes, AllowsXLinkAttributes permits SVGElementAdapter, org.tquadrat.foundation.svg.internal.SVGUseImpl
{
        /*---------*\
    ====** Methods **==========================================================
        \*---------*/
    /**
     *  Sets the height of the cloned element.
     *
     *  @param  value   The type; if {@code null} the
     *      attribute will be removed.
     */
    @SuppressWarnings( "UseOfConcreteClass" )
    public void setHeight( final SVGNumber value );

    /**
     *  Sets the width of the cloned element.
     *
     *  @param  value   The type; if {@code null} the
     *      attribute will be removed.
     */
    @SuppressWarnings( "UseOfConcreteClass" )
    public void setWidth( final SVGNumber value );

    /**
     *  Sets the x coordinate for the top left corner of the cloned element.
     *
     *  @param  value   The type; if {@code null} the
     *      attribute will be removed.
     */
    @SuppressWarnings( "UseOfConcreteClass" )
    public void setX( final SVGNumber value );

    /**
     *  Sets the y coordinate for the top left corner of the cloned element.
     *
     *  @param  value   The type; if {@code null} the
     *      attribute will be removed.
     */
    @SuppressWarnings( "UseOfConcreteClass" )
    public void setY( final SVGNumber value );
}
//  interface SVGUse

/*
 *  End of File
 */