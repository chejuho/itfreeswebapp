// PopupMenu
var PopupMenu = Class.create();

PopupMenu.prototype = {
	
	initialize: function(hotspot, menu) {
		this.hotspotElem = hotspot;
		this.menuElem = menu;                           
		Position.absolutize(this.menuElem);
		this.hideMenu();
		Event.observe(this.hotspotElem, "click", 
			this.onClickHotSpot.bindAsEventListener(this));
	},	
	onClickHotSpot: function(event)
	{
		if (this.menuShown())
		{
			this.hideMenu();
		}
		else
		{
			this.showMenu();
		}
	},
	onMouseMove: function(event)
	{
		if (this.menuShown())
		{
			if (!Position.within(this.menuElem, Event.pointerX(event), Event.pointerY(event)) &&
					!Position.within(this.hotspotElem, Event.pointerX(event), Event.pointerY(event))
			)
			{
				this.hideMenu();
			}
		}
	},
	
	menuShown: function()
	{
		return this.menuElem.visible();
	},
	
	showMenu: function()
	{
		pos = Position.positionedOffset(this.hotspotElem);
		dim = Element.getDimensions(this.hotspotElem);
		pos[1] += dim.height;
		
		Element.setStyle(this.menuElem, 
			{
				"left": pos[0] + "px",
				"top": pos[1] + "px"
			}
		);

		Effect.Appear(this.menuElem, 
			{ 
				duration: 0.1 
			}
		);
		this.onMouseMoveHandler = this.onMouseMove.bindAsEventListener(this);
		Event.observe(document, "mousemove", this.onMouseMoveHandler);
	},
	
	hideMenu: function()
	{
		if (this.onMouseMoveHandler)
		{
			Event.stopObserving(document, "mousemove", this.onMouseMoveHandler);
		}
		
		Effect.Fade(this.menuElem, 
			{ 
				duration: 0.1
			}
		);
	}
};
