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
import static org.tquadrat.foundation.lang.Objects.requireNotEmptyArgument;
import static org.tquadrat.foundation.svg.SVGUtils.SVGATTRIBUTE_Height;
import static org.tquadrat.foundation.svg.SVGUtils.SVGATTRIBUTE_Id;
import static org.tquadrat.foundation.svg.SVGUtils.SVGATTRIBUTE_Reference;
import static org.tquadrat.foundation.svg.SVGUtils.SVGATTRIBUTE_Width;
import static org.tquadrat.foundation.svg.SVGUtils.SVGATTRIBUTE_x;
import static org.tquadrat.foundation.svg.SVGUtils.SVGATTRIBUTE_y;
import static org.tquadrat.foundation.svg.SVGUtils.SVGELEMENT_Use;
import static org.tquadrat.foundation.svg.type.SVGElementCategory.ANIMATION;
import static org.tquadrat.foundation.svg.type.SVGElementCategory.DESCRIPTIVE;
import static org.tquadrat.foundation.xml.builder.XMLElement.Flags.ALLOWS_CHILDREN;
import static org.tquadrat.foundation.xml.builder.XMLElement.Flags.VALIDATES_ATTRIBUTES;
import static org.tquadrat.foundation.xml.builder.XMLElement.Flags.VALIDATES_CHILDREN;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.apiguardian.api.API;
import org.tquadrat.foundation.annotation.ClassVersion;
import org.tquadrat.foundation.svg.AllowsConditionalProcessingAttributes;
import org.tquadrat.foundation.svg.AllowsGraphicalEventAttributes;
import org.tquadrat.foundation.svg.AllowsPresentationAttributes;
import org.tquadrat.foundation.svg.AllowsXLinkAttributes;
import org.tquadrat.foundation.svg.SVGElement;
import org.tquadrat.foundation.svg.SVGUse;

/**
 *  The implementation for the interface
 *  {@link SVGUse}
 *  for the {@code <use>} element.
 *
 *  @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
 *  @version $Id: SVGUseImpl.java 820 2020-12-29 20:34:22Z tquadrat $
 *  @since 0.0.5
 *
 *  @UMLGraph.link
 */
@ClassVersion( sourceVersion = "$Id: SVGUseImpl.java 820 2020-12-29 20:34:22Z tquadrat $" )
@API( status = INTERNAL, since = "0.0.5" )
public final class SVGUseImpl extends SVGElementImpl implements SVGUse
{
        /*--------------*\
    ====** Constructors **=====================================================
        \*--------------*/
    /**
     *  Creates a new {@code SVGUseImpl} instance.
     *
     *  @param  reference   The reference to the cloned element.
     */
    public SVGUseImpl( final URI reference )
    {
        super( SVGELEMENT_Use, ALLOWS_CHILDREN, VALIDATES_ATTRIBUTES, VALIDATES_CHILDREN );

        //---* The children and attributes for the <use> element *-------------
        final Collection<String> childElements = new HashSet<>();
        childElements.addAll( ANIMATION.getElements() );
        childElements.addAll( DESCRIPTIVE.getElements() );

        final Collection<String> attributes = new ArrayList<>();
        attributes.addAll( List.of( SVGATTRIBUTE_Id, SVGATTRIBUTE_x,
            SVGATTRIBUTE_y, SVGATTRIBUTE_Width, SVGATTRIBUTE_Height,
            SVGATTRIBUTE_Reference ) );
        attributes.addAll( AllowsConditionalProcessingAttributes.CONDITIONALPROCESSING_ATTRIBUTES );
        attributes.addAll( SVGElement.CORE_ATTRIBUTES );
        attributes.addAll( AllowsGraphicalEventAttributes.GRAPHICALEVENT_ATTRIBUTES );
        attributes.addAll( AllowsPresentationAttributes.PRESENTATION_ATTRIBUTES );
        attributes.addAll( AllowsXLinkAttributes.XLINK_ATTRIBUTES );

        updateRegistries( childElements, attributes );

        setReference( requireNotEmptyArgument( reference, "reference" ) );
    }   //  SVGUseImpl()
}
//  class SVGUseImpl

/*
 *  End of File
 */