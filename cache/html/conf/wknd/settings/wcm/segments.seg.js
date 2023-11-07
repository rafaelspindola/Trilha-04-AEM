if (window.ContextHub && ContextHub.SegmentEngine) {
var S = ContextHub.SegmentEngine.Segment;
var SR = ContextHub.SegmentEngine.SegmentReference;
var P = ContextHub.SegmentEngine.Property;
var O = ContextHub.SegmentEngine.Operator;
var FR = ContextHub.SegmentEngine.ScriptReference;
var D = '/conf/wknd/settings/wcm/segments/';

new S(["Season Winter",D+"winter",0],new O('or',new O('and',new O('greater\u002Dthan.number',new P("geolocation\/latitude"),"40"),new O('or',new O('greater\u002Dthan\u002Dor\u002Dequal.number',new P("surferinfo\/month"),"9"),new O('less\u002Dthan.number',new P("surferinfo\/month"),"4"))),new O('and',new O('less\u002Dthan.number',new P("geolocation\/latitude"),"\u002D38"),new O('greater\u002Dthan\u002Dor\u002Dequal.number',new P("surferinfo\/month"),"4"),new O('less\u002Dthan.number',new P("surferinfo\/month"),"9")),new O('greater\u002Dthan.number',new P("geolocation\/latitude"),"70"),new O('less\u002Dthan.number',new P("geolocation\/latitude"),"\u002D50")));

new S(["Season Summer",D+"summer",0],new O('or',new O('and',new O('greater\u002Dthan.number',new P("geolocation\/latitude"),"40"),new O('greater\u002Dthan\u002Dor\u002Dequal.number',new P("surferinfo\/month"),"4"),new O('less\u002Dthan.number',new P("surferinfo\/month"),"9")),new O('and',new O('less\u002Dthan.number',new P("geolocation\/latitude"),"\u002D38"),new O('or',new O('less\u002Dthan.number',new P("surferinfo\/month"),"4"),new O('greater\u002Dthan\u002Dor\u002Dequal.number',new P("surferinfo\/month"),"9"))),new O('and',new O('greater\u002Dthan.number',new P("geolocation\/latitude"),"\u002D38"),new O('less\u002Dthan.number',new P("geolocation\/latitude"),"40"))));

}
