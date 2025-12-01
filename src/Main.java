import pt.iscte.greyditor.Greyditor;

void main() {
    Greyditor configuration = new Greyditor("VintageEditor");

    // Phase 1
    configuration.addFilter("Brightness", Filters::brightness, -255, 255);
    configuration.addFilter("Invert", Filters::invert);
    configuration.addEffect("Horizontal Flip", Effect::horizontalFlip);
    configuration.addEffect("Vertical Flip", Effect::verticalFlip);
    configuration.addFilter("Grain", Filters::grain);

    configuration.open("monalisa.jpg");
}