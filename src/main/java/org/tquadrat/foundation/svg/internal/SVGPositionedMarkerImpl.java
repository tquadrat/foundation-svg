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

package org.tquadrat.foundation.svg.internal;

import static org.apiguardian.api.API.Status.INTERNAL;
import static org.tquadrat.foundation.svg.SVGUtils.SVGATTRIBUTE_Position;

import org.apiguardian.api.API;
import org.tquadrat.foundation.annotation.ClassVersion;
import org.tquadrat.foundation.svg.SVGPositionedMarker;
import org.tquadrat.foundation.svg.type.SVGNumber;

/**
 *  The implementation of the interface
 *  {@link SVGPositionedMarker}
 *  for an SVG {@code <marker>} element that is used as a <i>positioned</i>
 *  marker.
 *
 *  @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
 *  @version $Id: SVGPositionedMarkerImpl.java 820 2020-12-29 20:34:22Z tquadrat $
 *  @since 0.0.5
 *
 *  @UMLGraph.link
 */
@ClassVersion( sourceVersion = "$Id: SVGPositionedMarkerImpl.java 820 2020-12-29 20:34:22Z tquadrat $" )
@API( status = INTERNAL, since = "0.0.5" )
public final class SVGPositionedMarkerImpl extends SVGMarkerImpl implements SVGPositionedMarker
{
        /*--------------*\
    ====** Constructors **=====================================================
        \*--------------*/
    /**
     *  Creates a new {@code SVGPositionedMarkerImpl} instance.
     */
    @SuppressWarnings( "RedundantNoArgConstructor" )
    public SVGPositionedMarkerImpl() { super(); }

        /*---------*\
    ====** Methods **==========================================================
        \*---------*/
    /**
     *  {@inheritDoc}
     */
    @SuppressWarnings( "UseOfConcreteClass" )
    @Override
    public final void setPosition( final SVGNumber value )
    {
        setAttribute( SVGATTRIBUTE_Position, value );
    }   //  setPosition()
}
//  class SVGPositionedMarkerImpl

/*
 *  End of File
 */