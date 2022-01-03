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

/**
 *  The definition of an SVG element that allows child elements.
 *
 *  @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
 *  @version $Id: SVGElementWithChildren.java 820 2020-12-29 20:34:22Z tquadrat $
 *  @since 0.0.5
 *
 *  @UMLGraph.link
 */
@ClassVersion( sourceVersion = "$Id: SVGElementWithChildren.java 820 2020-12-29 20:34:22Z tquadrat $" )
@API( status = STABLE, since = "0.0.5" )
public sealed interface SVGElementWithChildren extends SVGElement
    permits SVG, SVGClipPath, SVGGroup, SVGLine, SVGMarker, SVGPath, SVGRectangle, SVGSymbol, SVGTSpan, SVGText
{
        /*---------*\
    ====** Methods **==========================================================
        \*---------*/
    /**
     *  Adds a child to this element.
     *
     *  @param  <E> The implementation type for the {@code children}.
     *  @param  child   The child to add.
     *  @throws IllegalArgumentException    The given child is not valid for
     *      this element or no children are allowed at all.
     *  @throws IllegalStateException   The child has already a parent that is
     *      not this element.
     */
    public <E extends SVGElement> void addChild( final E child ) throws IllegalArgumentException, IllegalStateException;

    /**
     *  Sets the description for the SVG element.<br>
     *  <br>This is not an attribute, instead a
     *  <code>&lt;{@value SVGUtils#SVGELEMENT_Description}&gt;</code> element
     *  will be added as a child.
     *
     *  @param  description The description.
     */
    public void setDescription( final CharSequence description );
}
//  interface SVGElementWithChildren

/*
 *  End of File
 */