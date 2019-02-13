/*
 * This file is part of VLCJ.
 *
 * VLCJ is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * VLCJ is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with VLCJ.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright 2009-2019 Caprica Software Limited.
 */

package uk.co.caprica.vlcj.renderer;

import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.binding.internal.libvlc_event_e;
import uk.co.caprica.vlcj.binding.internal.libvlc_event_manager_t;
import uk.co.caprica.vlcj.binding.internal.libvlc_event_t;
import uk.co.caprica.vlcj.binding.internal.libvlc_instance_t;
import uk.co.caprica.vlcj.eventmanager.EventNotification;
import uk.co.caprica.vlcj.eventmanager.NativeEventManager;
import uk.co.caprica.vlcj.renderer.events.RendererDiscovererEventFactory;

/**
 *
 * <p>
 * For {@link #onCreateEvent(LibVlc, libvlc_instance_t, libvlc_event_t, RendererDiscoverer)} in this component, the
 * <code>libvlcInstance</code> parameter will be <code>null</code>.
 */
final class RendererDiscovererNativeEventManager extends NativeEventManager<RendererDiscoverer, RendererDiscovererEventListener> {

    RendererDiscovererNativeEventManager(LibVlc libvlc, RendererDiscoverer eventObject) {
        super(libvlc, null, eventObject, libvlc_event_e.libvlc_RendererDiscovererItemAdded, libvlc_event_e.libvlc_RendererDiscovererItemDeleted, "renderer-discoverer-events");
    }

    @Override
    protected libvlc_event_manager_t onGetEventManager(LibVlc libvlc, RendererDiscoverer eventObject) {
        return libvlc.libvlc_renderer_discoverer_event_manager(eventObject.rendererDiscovererInstance());
    }

    @Override
    protected EventNotification<RendererDiscovererEventListener> onCreateEvent(LibVlc libvlc, libvlc_instance_t libvlcInstance, libvlc_event_t event, RendererDiscoverer eventObject) {
        return RendererDiscovererEventFactory.createEvent(libvlc, eventObject, event);
    }

}
