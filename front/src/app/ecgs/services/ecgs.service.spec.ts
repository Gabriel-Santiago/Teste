import { TestBed } from '@angular/core/testing';

import { EcgsService } from './ecgs.service';

describe('EcgsService', () => {
  let service: EcgsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EcgsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
