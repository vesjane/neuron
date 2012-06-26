function draw_b() {
  var b_canvas = document.getElementById("viewport");
  var b_context = b_canvas.getContext("2d");

  for (var x = 0.5; x < 500; x += 10) {
    b_context.moveTo(x, 0);
    b_context.lineTo(x, 375);
  }
  for (var y = 0.5; y < 300; y += 10) {
    b_context.moveTo(0, y);
    b_context.lineTo(500, y);
  }
  b_context.strokeStyle = "#eee";
  b_context.stroke();

  b_context.beginPath();
  b_context.moveTo(0, 40);
  b_context.lineTo(240, 40);
  b_context.moveTo(260, 40);
  b_context.lineTo(500, 40);
  b_context.moveTo(495, 35);
  b_context.lineTo(500, 40);
  b_context.lineTo(495, 45);

  b_context.moveTo(60, 0);
  b_context.lineTo(60, 153);
  b_context.moveTo(60, 173);
  b_context.lineTo(60, 300);
  b_context.moveTo(65, 295);
  b_context.lineTo(60, 300);
  b_context.lineTo(55, 295);

  b_context.strokeStyle = "#000";
  b_context.stroke();

}