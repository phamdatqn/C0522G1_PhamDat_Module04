package currency_management.service.impl;

import currency_management.service.ICurrenCyService;
import org.springframework.stereotype.Service;

@Service
public class CurrenCyService implements ICurrenCyService {
    @Override
    public float convert(float number) {
        return number * 23000;
    }
}
