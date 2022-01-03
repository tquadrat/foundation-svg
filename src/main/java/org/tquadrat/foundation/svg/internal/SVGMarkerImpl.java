/*
 * ============================================================================
 * Copyright © 2002-2021 by Thomas Thrien.
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
import static org.tquadrat.foundation.lang.Objects.nonNull;
import static org.tquadrat.foundation.svg.SVGUtils.SVGATTRIBUTE_Class;
import static org.tquadrat.foundation.svg.SVGUtils.SVGATTRIBUTE_ExternalResourcesRequired;
import static org.tquadrat.foundation.svg.SVGUtils.SVGATTRIBUTE_Id;
import static org.tquadrat.foundation.svg.SVGUtils.SVGATTRIBUTE_MarkerHeight;
import static org.tquadrat.foundation.svg.SVGUtils.SVGATTRIBUTE_MarkerUnits;
import static org.tquadrat.foundation.svg.SVGUtils.SVGATTRIBUTE_MarkerWidth;
import static org.tquadrat.foundation.svg.SVGUtils.SVGATTRIBUTE_Orientation;
import static org.tquadrat.foundation.svg.SVGUtils.SVGATTRIBUTE_Position;
import static org.tquadrat.foundation.svg.SVGUtils.SVGATTRIBUTE_PreserveAspectRatio;
import static org.tquadrat.foundation.svg.SVGUtils.SVGATTRIBUTE_ReferenceX;
import static org.tquadrat.foundation.svg.SVGUtils.SVGATTRIBUTE_ReferenceY;
import static org.tquadrat.foundation.svg.SVGUtils.SVGATTRIBUTE_Style;
import static org.tquadrat.foundation.svg.SVGUtils.SVGATTRIBUTE_Transform;
import static org.tquadrat.foundation.svg.SVGUtils.SVGATTRIBUTE_ViewBox;
import static org.tquadrat.foundation.svg.SVGUtils.SVGELEMENT_AltGlyphDef;
import static org.tquadrat.foundation.svg.SVGUtils.SVGELEMENT_Anchor;
import static org.tquadrat.foundation.svg.SVGUtils.SVGELEMENT_ClipPath;
import static org.tquadrat.foundation.svg.SVGUtils.SVGELEMENT_ColorProfile;
import static org.tquadrat.foundation.svg.SVGUtils.SVGELEMENT_Cursor;
import static org.tquadrat.foundation.svg.SVGUtils.SVGELEMENT_Filter;
import static org.tquadrat.foundation.svg.SVGUtils.SVGELEMENT_Font;
import static org.tquadrat.foundation.svg.SVGUtils.SVGELEMENT_FontFace;
import static org.tquadrat.foundation.svg.SVGUtils.SVGELEMENT_ForeignObject;
import static org.tquadrat.foundation.svg.SVGUtils.SVGELEMENT_Image;
import static org.tquadrat.foundation.svg.SVGUtils.SVGELEMENT_Marker;
import static org.tquadrat.foundation.svg.SVGUtils.SVGELEMENT_Mask;
import static org.tquadrat.foundation.svg.SVGUtils.SVGELEMENT_Pattern;
import static org.tquadrat.foundation.svg.SVGUtils.SVGELEMENT_Script;
import static org.tquadrat.foundation.svg.SVGUtils.SVGELEMENT_Style;
import static org.tquadrat.foundation.svg.SVGUtils.SVGELEMENT_Switch;
import static org.tquadrat.foundation.svg.SVGUtils.SVGELEMENT_Text;
import static org.tquadrat.foundation.svg.SVGUtils.SVGELEMENT_View;
import static org.tquadrat.foundation.svg.type.SVGElementCategory.ANIMATION;
import static org.tquadrat.foundation.svg.type.SVGElementCategory.DESCRIPTIVE;
import static org.tquadrat.foundation.svg.type.SVGElementCategory.GRADIENT;
import static org.tquadrat.foundation.svg.type.SVGElementCategory.SHAPE;
import static org.tquadrat.foundation.svg.type.SVGElementCategory.STRUCTURAL;
import static org.tquadrat.foundation.xml.builder.XMLElement.Flags.ALLOWS_CHILDREN;
import static org.tquadrat.foundation.xml.builder.XMLElement.Flags.VALIDATES_ATTRIBUTES;
import static org.tquadrat.foundation.xml.builder.XMLElement.Flags.VALIDATES_CHILDREN;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.apiguardian.api.API;
import org.tquadrat.foundation.annotation.ClassVersion;
import org.tquadrat.foundation.svg.AllowsPresentationAttributes;
import org.tquadrat.foundation.svg.AllowsStyleAttributes;
import org.tquadrat.foundation.svg.SVGMarker;
import org.tquadrat.foundation.svg.type.SVGMarkerOrientation;
import org.tquadrat.foundation.svg.type.SVGNumber;
import org.tquadrat.foundation.svg.type.SVGNumber.SVGDegree;

/**
 *  The implementation for the interface
 *  {@link SVGMarker}
 *  for the SVG {@code <marker>}.
 *
 *  @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
 *  @version $Id: SVGMarkerImpl.java 840 2021-01-10 21:37:03Z tquadrat $
 *  @since 0.0.5
 *
 *  @UMLGraph.link
 */
@ClassVersion( sourceVersion = "$Id: SVGMarkerImpl.java 840 2021-01-10 21:37:03Z tquadrat $" )
@API( status = INTERNAL, since = "0.0.5" )
public sealed class SVGMarkerImpl extends SVGElementImpl implements SVGMarker
    permits SVGPositionedMarkerImpl
{
        /*--------------*\
    ====** Constructors **=====================================================
        \*--------------*/
    /**
     *  Creates a new {@code SVGMarkerImpl} instance.
     */
    public SVGMarkerImpl()
    {
        super( SVGELEMENT_Marker, ALLOWS_CHILDREN, VALIDATES_ATTRIBUTES, VALIDATES_CHILDREN );

        //---* The children and attributes for the <marker> element *----------
        final Collection<String> childElements = new HashSet<>();
        childElements.addAll( ANIMATION.getElements() );
        childElements.addAll( DESCRIPTIVE.getElements() );
        childElements.addAll( SHAPE.getElements() );
        childElements.addAll( STRUCTURAL.getElements() );
        childElements.addAll( GRADIENT.getElements() );
        childElements.addAll( List.of( SVGELEMENT_Anchor,
            SVGELEMENT_AltGlyphDef, SVGELEMENT_ClipPath,
            SVGELEMENT_ColorProfile, SVGELEMENT_Cursor, SVGELEMENT_Filter,
            SVGELEMENT_Font, SVGELEMENT_FontFace, SVGELEMENT_ForeignObject,
            SVGELEMENT_Image, SVGELEMENT_Marker, SVGELEMENT_Mask,
            SVGELEMENT_Pattern, SVGELEMENT_Script, SVGELEMENT_Style,
            SVGELEMENT_Switch, SVGELEMENT_Text, SVGELEMENT_View ) );

        final Collection<String> attributes = new ArrayList<>();
        attributes.addAll( List.of( SVGATTRIBUTE_Id,
            SVGATTRIBUTE_PreserveAspectRatio, SVGATTRIBUTE_ViewBox,
            SVGATTRIBUTE_MarkerUnits, SVGATTRIBUTE_ReferenceX,
            SVGATTRIBUTE_ReferenceY, SVGATTRIBUTE_MarkerWidth,
            SVGATTRIBUTE_MarkerHeight, SVGATTRIBUTE_Orientation,
            SVGATTRIBUTE_Class, SVGATTRIBUTE_Style,
            SVGATTRIBUTE_ExternalResourcesRequired, SVGATTRIBUTE_Transform,
            SVGATTRIBUTE_Position ) );
        attributes.addAll( CORE_ATTRIBUTES );
        attributes.addAll( AllowsStyleAttributes.STYLE_ATTRIBUTES );
        attributes.addAll( AllowsPresentationAttributes.PRESENTATION_ATTRIBUTES );

        updateRegistries( childElements, attributes );
    }   //  SVGMarkerImpl()

        /*---------*\
    ====** Methods **==========================================================
        \*---------*/
    /**
     *  {@inheritDoc}
     */
    @Override
    public final void setMarkerHeight( final SVGNumber value )
    {
        setAttribute( SVGATTRIBUTE_MarkerHeight, value );
    }   //  setMarkerHeight()

    /**
     *  {@inheritDoc}
     */
    @Override
    public final void setMarkerUnits( final boolean flag )
    {
        setAttribute( SVGATTRIBUTE_MarkerUnits, flag ? "userSpaceOnUse" : "strokeWidth" );
    }   //  setMarkerUnits()

    /**
     *  {@inheritDoc}
     */
    @Override
    public final void setMarkerWidth( final SVGNumber value )
    {
        setAttribute( SVGATTRIBUTE_MarkerWidth, value );
    }   //  setMarkerWidth()

    /**
     *  {@inheritDoc}
     */
    @Override
    public final void setOrientation( final SVGMarkerOrientation value )
    {
        setAttribute( SVGATTRIBUTE_Orientation, nonNull( value ) ? value.toString() : null );
    }   //  setOrientation()

    /**
     *  {@inheritDoc}
     */
    @Override
    public final void setOrientation( final SVGDegree value )
    {
        setAttribute( SVGATTRIBUTE_Orientation, nonNull( value ) ? value.toString() : null );
    }   //  setOrientation()

    /**
     *  {@inheritDoc}
     */
    @Override
    public final void setReferenceX( final SVGNumber value )
    {
        setAttribute( SVGATTRIBUTE_ReferenceX, value );
    }   //  setReferenceX()

    /**
     *  {@inheritDoc}
     */
    @Override
    public final void setReferenceY( final SVGNumber value )
    {
        setAttribute( SVGATTRIBUTE_ReferenceY, value );
    }   //  setReferenceY()
}
//  class SVGMarkerImpl

/*
 *  End of File
 */