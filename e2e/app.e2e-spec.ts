import { OnlineCosmeticsPage } from './app.po';

describe('online-cosmetics App', function() {
  let page: OnlineCosmeticsPage;

  beforeEach(() => {
    page = new OnlineCosmeticsPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
