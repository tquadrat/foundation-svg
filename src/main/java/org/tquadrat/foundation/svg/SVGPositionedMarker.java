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
 *  The definition for the SVG {@code <marker>} element when used as a
 *  positioned marker.
 *
 *  @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
 *  @version $Id: SVGPositionedMarker.java 820 2020-12-29 20:34:22Z tquadrat $
 *  @since 0.0.5
 *
 *  @UMLGraph.link
 */
@ClassVersion( sourceVersion = "$Id: SVGPositionedMarker.java 820 2020-12-29 20:34:22Z tquadrat $" )
@API( status = STABLE, since = "0.0.5" )
public sealed interface SVGPositionedMarker extends SVGMarker permits SVGElementAdapter, org.tquadrat.foundation.svg.internal.SVGPositionedMarkerImpl
{
        /*---------*\
    ====** Methods **==========================================================
        \*---------*/
    /**
     *  Sets the relative position for this marker.
     *
     *  @param  value   The distance.
     */
    public void setPosition( final SVGNumber value );
}
//  interface SVGPositionedMarker

/*
 *  End of File
 */