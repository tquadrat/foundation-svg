/*
 * ============================================================================
 * Copyright © 2002-2023 by Thomas Thrien.
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
import org.tquadrat.foundation.svg.internal.SVGClipPathImpl;

/**
 *  The definition of the SVG {@code <clipPath>} element.
 *
 *  @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
 *  @version $Id: SVGClipPath.java 1074 2023-10-02 12:05:06Z tquadrat $
 *  @since 0.0.5
 *
 *  @UMLGraph.link
 */
@ClassVersion( sourceVersion = "$Id: SVGClipPath.java 1074 2023-10-02 12:05:06Z tquadrat $" )
@API( status = STABLE, since = "0.0.5" )
public sealed interface SVGClipPath extends AllowsConditionalProcessingAttributes, AllowsPresentationAttributes, SVGElementWithChildren
    permits SVGElementAdapter, SVGClipPathImpl
{
        /*---------*\
    ====** Methods **==========================================================
        \*---------*/
    /**
     *  Sets the {@value SVGUtils#SVGATTRIBUTE_ClipPathUnits} attribute that
     *  defines the coordinate system for the contents of this
     *  {@code <clipPath>} element.
     *
     *  @param  flag    {@code true} if the user coordinate system for the
     *      contents of the {@code <clipPath>} element is established using the
     *      bounding box of the element to which the clipping path is applied,
     *      {@code false} if the contents of the {@code <clipPath>} element
     *      represents values in the current user coordinate system in place at
     *      the time when the {@code <clipPath>} element is referenced.
     */
    public void setClipPathUnits( final boolean flag );
}
//  interface SVGClipPath

/*
 *  End of File
 */